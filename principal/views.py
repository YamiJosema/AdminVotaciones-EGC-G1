from principal.models import *
from principal.forms import *
from django.shortcuts import render_to_response, get_list_or_404
#Para autenticacion
from django.contrib.auth import authenticate
#Para usar Formularios
#from principal.forms import *
from django.http import HttpResponse, HttpResponseRedirect
from django.template import RequestContext

from datetime import datetime


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

def votaciones_futuras(request):
    now = datetime.today().date()    
    votaciones = Poll.objects.filter(startDate__range=[now, "2050-01-31"])
    return render_to_response("lista.html",{"votaciones":votaciones, "preguntas":True})

def nueva_pregunta(request, poll_id):
    if request.method=='POST':
        formulario = QuestionForm(request.POST, request.FILES)
        if formulario.is_valid():
            poll = Poll.objects.get(id=poll_id)
            Question.objects.create(title=formulario.cleaned_data['title'], description=formulario.cleaned_data['description'], optional=formulario.cleaned_data['optional'], multiple=formulario.cleaned_data['multiple'], poll=poll)
#             formulario.save()
#             return HttpResponseRedirect('/nuevapregunta/'+poll_id)
            return HttpResponseRedirect('/')
    else:
        formulario = QuestionForm()
    return render_to_response('nuevapregunta.html',{'formulario':formulario}, context_instance=RequestContext(request))
