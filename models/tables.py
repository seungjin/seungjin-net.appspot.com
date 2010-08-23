

from google.appengine.ext import db

class Journals(db.Model):
  uid = db.IntegerProperty()
  date = db.DateProperty()
  time = db.TimeProperty()
  timezone = db.StringProperty()
  tag = db.StringProperty(multiline=True)
  subject = db.StringProperty(multiline=True)
  publishing_code = db.IntegerProperty()
  body = db.TextProperty()
  ref = db.StringProperty(multiline=True)
  created_at = db.DateTimeProperty(auto_now_add=True)

class Access_logs(db.Model):
  uid = db.IntegerProperty()
  timestamp = db.DateTimeProperty()
  timezone = db.StringProperty()
  remote_ip = db.StringProperty()
  user_agent = db.StringProperty()
  url = db.StringProperty()
  http_referer = db.StringProperty()

class Received_emails(db.Model):
	uid = db.IntegerProperty()
	status = db.StringProperty()
	mail_from = db.StringProperty()
	mail_to = db.StringProperty()
	subject = db.StringProperty()
	body = db.TextProperty()
	rcf822 = db.TextProperty()
	received_at = db.DateTimeProperty()
	updated_at = db.DateTimeProperty()
	
class Guestbooks(db.Model):
	uid = db.IntegerProperty()
	name = db.StringProperty()
	timestamp = db.DateTimeProperty()
	timezone = db.StringProperty()
	message = db.TextProperty()
	publishing_code = db.StringProperty()
	password = db.StringProperty()
	remote_ip = db.StringProperty()
	user_agent = db.StringProperty()
	created_at = db.DateTimeProperty()

class My_groips(db.Model):
	uid = db.IntegerProperty()
	remote_ip = db.StringProperty()
	geo = db.StringProperty()
	note = db.StringProperty()
	timestamp = db.DateTimeProperty()
	timezone = db.StringProperty()
	referring_access_log_id = db.StringProperty()
	
class Shouts(db.Model):
  message = db.TextProperty()
  remote_addr = db.StringProperty()
  user_agent = db.StringProperty()
  publishing_code = db.IntegerProperty()
  created_at = db.DateTimeProperty(auto_now=True)
  updated_at = db.DateTimeProperty()
  
  