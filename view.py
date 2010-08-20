
from google.appengine.ext import webapp
from google.appengine.ext.webapp.util import run_wsgi_app

from controllers.journal import Journal
from controllers.devTool import ImportAll
from controllers.devTool import DeleteAll


class MainPage(webapp.RequestHandler) :
  def get(self):
    self.response.headers['Content-Type'] = 'text/plain'
    self.response.out.write('Hello, webapp World!')

application = webapp.WSGIApplication([
    ('/',Journal),
    ('/import', ImportAll),
    ('/delete', DeleteAll)
], debug=True) 

def main():
  run_wsgi_app(application)

if __name__ == "__main__":
  main()