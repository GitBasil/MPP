# Lesson 8 Notes

## Note 1
orElseGet vs orElse
orElse: is always called but then the result is igored if the else condtion is not met
orElseGet: is only called if the else part is met.


## Note 2
the Lambda Library will have a question in the exam

## Note 3
stateless vs stateful
stateless: each element of the stream is processed and forgotten. (map , filter , concat)
stateful: you need to link the element with another element to complete the task. (limit, skip, distinct, sorted)