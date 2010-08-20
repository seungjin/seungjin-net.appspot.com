import cgi

from google.appengine.ext import webapp
from google.appengine.ext import db

from models.tables import *
  
class Journal(webapp.RequestHandler) :
  def get(self):
    self.response.headers['Content-Type'] = 'text/plain'
    self.response.out.write('journal')
    journals = db.GqlQuery("SELECT * FROM Journals")
    for journal in journals :
      print journal