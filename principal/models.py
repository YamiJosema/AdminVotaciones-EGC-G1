from django.db import models

class Ca(models.Model):
    id = models.IntegerField(primary_key=True, unique=True, null=False)
    name = models.CharField(max_length=100, null=False, blank=False)
    class Meta:
        db_table = 'ca'
    def __unicode__(self):
        return self.name

class Census(models.Model):
    id = models.IntegerField(unique=True, primary_key=True, null=False)
    title = models.CharField(max_length=100, null=False)
    postalCode = models.IntegerField(null=True, blank=True, db_column='postalCode')
    ca = models.ForeignKey(Ca)
    class Meta:
        db_table = 'census'
    def __unicode__(self):
        return self.title
    
class Poll(models.Model):
    id = models.IntegerField(unique=True, primary_key=True, null=False)
    title = models.CharField(max_length=100, null=False, blank=False)
    description = models.CharField(max_length=500, null=False)
    startDate = models.DateField(null=False, db_column='startDate')
    endDate = models.DateField(null=False, db_column='endDate') 
    census = models.ForeignKey(Census)
    class Meta:
        db_table = 'poll'
    def __unicode__(self):
        return self.title

class Question(models.Model):
    id = models.IntegerField(unique=True, null=False, primary_key=True)
    title = models.CharField(max_length=100, null=False, balnk=False)
    description = models.CharField(max_length=500, null=False, blank=True)
    optional = models.BooleanField()
    multiple = models.BooleanField()
    poll = models.ForeignKey(Poll)
    class Meta:
        db_table = 'question'
    def __unicode__(self):
        return self.title

class Option(models.Model):
    id = models.IntegerField(unique=True, null=False, primary_key=True)
    description = models.CharField(max_length=500, null=False, blank=True)
    question = models.ForeignKey(Question)
    class Meta:
        db_table = 'question_option'
    def __unicode__(self):
        return self.description