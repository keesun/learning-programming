taxrate = 0.75
print "Enter price: "
s = gets
subtotal = s.to_f

if(subtotal < 0.0) then
  subtotal = 0.0
end

tax = subtotal * taxrate
puts "Tax on $#{subtotal} is $#{tax}, so grand total is $#{subtotal + tax}"