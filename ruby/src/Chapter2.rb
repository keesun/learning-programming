class Things
  @@count = 0
  attr_accessor(:id, :name)

  def initialize(id, name)
    @id = id;
    @name = name;
    @@count += 1
  end

  def print_count
    puts @@count;
  end
end

class Books < Things
  attr_accessor(:isbn, :author)

  def initialize(id, name, isbn, author)
    super(id, name)
    @isbn = isbn;
    @author = author;
  end
end

white_book = Books.new(1, "whitebook", "123123", "keesun")
puts(white_book)
white_book.print_count()

x = white_book.class
begin
  x = x.superclass
  puts(x.inspect)
end until x == nil

class Array
  def what
    puts("what")
  end
end

[1,2,3].what();