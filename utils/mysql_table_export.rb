#!/usr/env ruby
require 'Database_connection'

require 'rubygems' #ruby 1.9 does not need it
require 'builder'
require 'iconv'

$KCODE = "UTF-8"
$dbcon = Database_connection.new().seungjin()
$builder = Builder::XmlMarkup.new(:target=>$resultxml="", :indent=>2, :encoding=>'UTF-8')
$builder.instruct!(:xml, :version => "1.0", :encoding => "UTF-8")

def table_exist?(table_name)
  r = false
  for t in $dbcon.list_tables.each do
    if t == table_name
      r = true
    end
  end
  return r
end

def export_table(table_name)
  if table_exist?(table_name) == true
    res = $dbcon.query("select * from " + table_name)
    res.each_hash(with_table=false) do |row|
      $builder.row { |b|
        for i in res.fetch_fields do
          eval("b.#{i.name}(row['#{i.name}'])")
        end
      }
    end
  end
end

ARGV.each do |table_name|
  export_table(table_name)
  puts $resultxml
end