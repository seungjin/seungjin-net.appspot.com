
from google.appengine.ext import webapp
from google.appengine.ext.webapp.util import run_wsgi_app

from controllers.journal import Journal
from controllers.util import Util
from controllers.shout import Shout
from controllers.dump import Dump

application = webapp.WSGIApplication([
    (r'/',Journal),
    (r'/j/',Journal),
    #(r'/j/write',Journal),
    (r'/shout', Shout),
    (r'/shout/(.*)', Shout),
    (r'/util', Util),
    #(r'/dump', Dump),
], debug=True) 

def main():
  run_wsgi_app(application)

if __name__ == "__main__":
  main()