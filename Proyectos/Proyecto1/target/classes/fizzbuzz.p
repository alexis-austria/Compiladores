counter = 1
while (counter < 31):
    if counter % 3 == 0:
        print "fizz"
    if counter % 5 == 0:
        print "buzz"
    if counter % 5 != 0 and counter % 3 != 0:
        print counter
    counter+= 1
