localvar = "hello"
$glovalvar = "goodbye"

def amethod
  localvar = 10
  puts localvar
  puts $glovalvar
end

def anotherMethod
  localvar = 500
  $glovalvar = "bonjour"
  puts( localvar )
  puts( $glovalvar )
end

amethod
anotherMethod
amethod
puts $glovalvar