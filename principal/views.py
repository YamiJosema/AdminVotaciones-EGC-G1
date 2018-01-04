from principal.models import *
from principal.forms import *
from django.shortcuts import render_to_response, get_list_or_404
#Para autenticacion
from django.contrib.auth import authenticate
#Para usar Formularios
#from principal.forms import *
from django.contrib.auth.models import User
from django.http import HttpResponse, HttpResponseRedirect
from django.template import RequestContext


def inicio(request):
    votaciones = Poll.objects.all()
    return render_to_response("lista.html",{"votaciones":votaciones})

def nueva_votacion(request):
    if request.method=='POST':
        formulario = PollForm(request.POST, request.FILES)
        if formulario.is_valid():
            formulario.save()
            return HttpResponseRedirect('/')
    else:
        formulario = PollForm()
    return render_to_response('nuevavotacion.html',{'formulario':formulario}, context_instance=RequestContext(request))