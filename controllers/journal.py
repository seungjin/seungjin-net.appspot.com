
import os
import cgi
import datetime

import settings

from google.appengine.ext import webapp
from google.appengine.ext import db
from google.appengine.ext.webapp import template

from models.tables import *
  
class Journal(webapp.RequestHandler) :
  def get(self):
    journals = db.GqlQuery("SELECT * FROM Journals")
    for journal in journals :
      print journal

    #self.response.headers['Content-Type'] = 'text/plain'
    template_values = {
      'date': datetime.datetime.now().strftime("%a %b %d %H:%M:%S %Z %Y"),
    }
    path = os.path.join(settings.APP_ROOT_PATH,"./templates/journal.html")
    self.response.out.write(template.render(path, template_values))