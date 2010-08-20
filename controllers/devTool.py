
from google.appengine.ext import webapp
from models.tables import *

import urllib2
from xml.dom.minidom import parse, parseString


class ImportAll(webapp.RequestHandler):
  def get(self):
    # http://b.seungjin.net/Journals/form=xml&begin=0&size=4294967295
    url = "http://b.seungjin.net/Journals/form=xml&begin=0&size=4294967295"
    try :
      result = urllib2.urlopen(url)  
    except urllib2.URLError, e:
      handleError(e)
    journal_source = result.read()
    self.response.headers['Content-Type'] = 'text/plain'
    self.response.out.write(".")
    dom1 = parseString(journal_source)
    for a in dom1.getElementsByTagName('journals'):
        self.response.out.write(a)
    j = Journal()
    j.jid = 0
    j.put()

class DeleteAll(webapp.RequestHandler):
  def get(self):
    
    query = Journal.all()
    j_entries = query.fetch(10000)
    db.delete(j_entries)
    
    access_log = Access_Log.all()
    a_entries = query.fetch(10000)
    db.delete(a_entries)
    
    self.response.headers['Content-Type'] = 'text/plain'
    self.response.out.write('hello world')