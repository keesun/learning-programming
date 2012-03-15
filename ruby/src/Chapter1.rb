s = 'Keesun';
puts "Hello #{s}, #{2000 + 12}"
if(true) then
  puts "Puss int the Boots"
end

class Company

  $founder = "Toby"

  def initialize(name)
    @name = name;
  end

  def set_name(name)
    @name = name
  end

  def get_name
    @name
  end

  #def to_s
  #  "name: #{@name}"
  #end

  def show
    employee = "Keesun"

    puts "The founder is #{$founder}. and one employee is #{employee}"
  end
end

epril = Company.new("Epril'")
puts epril.get_name

puts epril
puts epril.inspect
p(epril)

epril.show


