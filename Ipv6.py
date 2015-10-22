def get_ip_6(host, port=0):
    import socket
    
    result = socket.getaddrinfo(host, port, socket.AF_INET6)
    return result #or

    return result[0][4][0]
