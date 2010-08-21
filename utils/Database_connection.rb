#!/usr/bin/env ruby

require 'rubygems'
require 'mysql'


class Database_connection

	def seungjin
    conn = Mysql::real_connect('mysql.server.com','username','password','database_name')
    conn.query( "SET NAMES 'utf8' " );
    conn
	end
	
	def seungjin_dev
	  conn = Mysql::real_connect('mysql.server.com','username','password','database_name')
    conn.query( "SET NAMES 'utf8' " );
    conn
	end
