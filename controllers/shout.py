
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
  
class Shout(webapp.RequestHandler) :

  def get(self,rownum = None):
    if (rownum is None or rownum is "") :
      shouts = db.GqlQuery("SELECT * FROM Shouts ORDER BY created_at DESC")
      template_values = {
        'date': datetime.datetime.now().strftime("%a %b %d %H:%M:%S %Z %Y"),
        'shouts': shouts,
        'this_resource' : "http://" + self.request.headers.get('host', 'no host') + "/shout/"
      }
      path = os.path.join(settings.APP_ROOT_PATH,"./templates/shout/index.html")
      self.response.out.write(template.render(path, template_values))
    else:
      shouts = Shouts.gql("WHERE rownum = " +rownum)
      
      #print self.request.headers.get('host', 'no host')
      #print wsgiref.util.request_uri(self.request.environ)
      
      template_values = {
        'date': datetime.datetime.now().strftime("%a %b %d %H:%M:%S %Z %Y"),
        'shouts': shouts,
        'this_resource' : "http://" + self.request.headers.get('host', 'no host') + "/shout/" + rownum
      }
      path = os.path.join(settings.APP_ROOT_PATH,"./templates/shout/read.html")
      self.response.out.write(template.render(path, template_values))
      
  def post(self):
    
    # need to start a transaction
    q = db.GqlQuery("SELECT * FROM Shouts")
    if q.count() == 0 :
      rownum = 1
    else :
      rownum = 1 + q.count()
     
    if self.request.get('message') != '' :
      shouts = Shouts()
      shouts.rownum = rownum
      shouts.message = self.request.get('message').rstrip()
      shouts.publishing_code = 1
      shouts.remote_addr = self.request.remote_addr
      shouts.user_agent = self.request.headers['User-Agent']   
      shouts.put()
    # need to end a transaction
    
    self.redirect('/shout')