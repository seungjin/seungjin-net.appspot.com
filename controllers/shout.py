
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

    #self.response.headers['Content-Type'] = 'text/plain'
    template_values = {
      'date': datetime.datetime.now().strftime("%a %b %d %H:%M:%S %Z %Y"),
    }
    path = os.path.join(settings.APP_ROOT_PATH,"./templates/shout.html")
    self.response.out.write(template.render(path, template_values))

  def post(self):
    print self.request