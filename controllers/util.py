
import os
import cgi
import datetime
import logging

import settings

from google.appengine.ext import webapp
from google.appengine.ext import db

from models.tables import *
  
class Util(webapp.RequestHandler) :
  def get(self):
    self.response.headers['Content-Type'] = 'text/plain'
    self.response.out.write("util:")
    self.response.out.write(self.request.query_string)
    
