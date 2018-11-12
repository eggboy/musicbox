echo "GET https://musicbox.apps.pcfone.io/music/1" \
| vegeta -cpus=12 attack -duration=300s \
| vegeta report -reporter=plot > plot.html
