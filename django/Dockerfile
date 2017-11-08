FROM python:3
RUN mkdir /data
WORKDIR /data
ADD django/requirements.txt /data
RUN pip install -r requirements.txt
ADD django /data