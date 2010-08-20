
from google.appengine.ext import webapp
from google.appengine.ext.webapp.util import run_wsgi_app

from controllers.journal import Journal
from controllers.devTool import *

application = webapp.WSGIApplication([
    ('/',Journal),
    ('/import', ImportAll),
    ('/delete', DeleteAll)
], debug=True) 

def main():
  run_wsgi_app(application)

if __name__ == "__main__":
  main()