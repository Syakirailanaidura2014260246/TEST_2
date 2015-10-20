import ctypes
import socket
import struct
import urllib2

def getinfo_company(host):
   
    try:
        SendARP = ctypes.windll.Iphlpapi.SendARP
    except:
        raise NotImplementedError('Operated on Windows 2000 and above')
    
    if host == '127.0.0.1' or host.lower() == 'localhost':
        host = socket.gethostname()
        
    try:
        inetaddr = ctypes.windll.wsock32.inet_addr(host)
        if inetaddr == 0 or inetaddr == -1:
            raise Exception
              
    except:
        hostip = socket.gethostbyname(host)
        inetaddr = ctypes.windll.wsock32.inet_addr(hostip)
    
    buffer = ctypes.c_buffer(6)
    addlen = ctypes.c_ulong(ctypes.sizeof(buffer))
    if SendARP(inetaddr, 0, ctypes.byref(buffer), ctypes.byref(addlen)) != 0:
        raise WindowsError('Retreival of mac address(%s) - failed' % host)
    
    macaddr = ''
    for intval in struct.unpack('BBBBBB', buffer):
        if intval > 15:
            replacestr = '0x'
        else:
            replacestr = 'x'
        macaddr = ''.join([macaddr, hex(intval).replace(replacestr, '')])
    
    return macaddr.upper()

if __name__ == '__main__':
    print 'Your MAC ADDRESS is %s' % getinfo_company('localhost')


