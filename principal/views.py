from principal.models import *
from django.shortcuts import render_to_response, get_list_or_404
#Para autenticacion
from django.contrib.auth import authenticate
#Para usar Formularios
#from principal.forms import *
from django.contrib.auth.models import User
from django.http import HttpResponse, HttpResponseRedirect
from django.template import RequestContext


def inicio(request):
    return render_to_response("base.html",)