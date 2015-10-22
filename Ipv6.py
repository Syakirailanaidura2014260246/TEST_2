def get_ip_6(host, port=0):
    import socket
    
    result = socket.getaddrinfo(host, port, socket.AF_INET6)
<<<<<<< HEAD
    return result 
=======
    return result #or

>>>>>>> refs/remotes/origin/master
    return result[0][4][0]
