# A3

Zusammenfassung:

Ich habe mit Postman insgesamt 17'200 Requests (282.03/s) an die Webapp geschickt.

In diesen Requests gab es einerseits einen Get (Get students) und einen Post (Post student) Request.

Der Get-Request hatte eine Error-Rate von 100% welche aus Transport und Netzwerk Fehler bestand und eine Durchschnittliche Response time von 1 ms hatte.
Der Post-Request verlief fehlerfrei und hatte eine Durchschnittliche Reponse time von 15-60 ms mit einem kurzen Spike zu 299 ms am Anfang.

Insgesamt gab es eine Fehlerrate von 50.11%, eine Durchschnittliche Response time von 24 ms und interessanterweise gab es am Anfang des Stress-testing einen Spike der Response time bis auf 162.323 ms, während dem Rest des Tests war es etwa auf 20 ms.

Während des ganzen Tests gab es keinen einzigen Failure.
