
import os
import cgi
import datetime
import logging

import settings

from google.appengine.ext import webapp
from google.appengine.ext import db
from google.appengine.ext.webapp import template

from models.tables import *
  
class Shout(webapp.RequestHandler) :
  def get(self):
    shouts = db.GqlQuery("SELECT * FROM Shouts ORDER BY created_at DESC")
    template_values = {
      'date': datetime.datetime.now().strftime("%a %b %d %H:%M:%S %Z %Y"),
      'shouts': shouts
    }
    path = os.path.join(settings.APP_ROOT_PATH,"./templates/shout.html")
    self.response.out.write(template.render(path, template_values))

  def post(self):
    if self.request.get('message') != '' :
      shouts = Shouts()
      shouts.uid = db.IntegerProperty()
      shouts.message = self.request.get('message').rstrip()
      shouts.publishing_code = 1
      shouts.remote_addr = self.request.remote_addr
      shouts.user_agent = self.request.headers['User-Agent']   
      shouts.put()
    self.redirect('/shout')