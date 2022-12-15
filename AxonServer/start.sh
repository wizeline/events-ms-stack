#!/bin/bash

docker run -d --rm --name axonserver-se -p 8025:8025 -p 8124:8124 \
    -v `pwd`/data:/data \
    -v `pwd`/eventdata:/eventdata \
    -v `pwd`/config:/config \
    -v `pwd`/log:/log \
    axoniq/axonserver