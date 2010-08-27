
import os
import cgi
import datetime
import logging

import settings

from google.appengine.ext import webapp
from google.appengine.ext import db
from google.appengine.ext.webapp import template
import wsgiref.util

from models.tables import *
  
class Journal(webapp.RequestHandler) :
  
  def get(self):
    
    ## access_log
    # need to start a transaction
    q = db.GqlQuery("SELECT * FROM Access_logs")
    if q.count() == 0 :
      access_logs_rownum = 1
    else :
      access_logs_rownum = 1 + q.count()
    
    #print os.environ['HTTP_REFERER']
    #print self.request.header['HTTP_REFERER']
    try :
      http_referer = os.environ['HTTP_REFERER']
    except :
      http_referer = None
      
    access_logs = Access_logs()
    access_logs.rownum = access_logs_rownum
    access_logs.url = wsgiref.util.request_uri(self.request.environ)
    access_logs.http_referer = http_referer
    access_logs.remote_addr = self.request.remote_addr
    access_logs.user_agent = self.request.headers['User-Agent']   
    access_logs.put()
    # need to end a transaction
    
    journals = db.GqlQuery("SELECT * FROM Journals WHERE publishing_code = 1 ORDER BY rownum DESC LIMIT 100")
    #self.response.out.write(self.request.query_string)

    #self.response.headers['Content-Type'] = 'text/plain'
    template_values = {
      'date': datetime.datetime.now().strftime("%a %b %d %H:%M:%S %Z %Y"),
      'journals' : journals
    }
    path = os.path.join(settings.APP_ROOT_PATH,"./templates/journal.html")
    self.response.out.write(template.render(path, template_values))

  def post(self):
    print self.request
