#encoding:utf-8
from django.forms import ModelForm
from principal.models import Poll

class PollForm(ModelForm):
    class Meta:
        model = Poll
        fields = ['title','description','startDate','endDate', 'census']
