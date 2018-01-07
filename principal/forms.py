from models import Poll, Question
from django.forms import ModelForm


class PollForm(ModelForm):
    class Meta:
        model = Poll
        fields = ['title','description','startDate','endDate', 'census']

class QuestionForm(ModelForm):
    class Meta:
        model = Question
        fields = ['title', 'description', 'optional', 'multiple']