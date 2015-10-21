import thread
import time

def Time(threadName, delay):
   count = 0
   while count < 5:
      time.sleep(delay)
      count += 1
      print "%s: %s" % ( threadName, time.ctime(time.time()) )
      
try:
   thread.start_new_thread( Time, ("Thread-1", 2, ) )
   thread.start_new_thread( Time, ("Thread-2", 4, ) )
except:
   print "Error: unable to start thread"

while 1:
   pass
