Deadlock occurs in this system when every philosopher acquires a fork on their left, and thus cannot acquire a fork on their right as there are no more forks on the table. 

The deadlock in a system of 3 philosophers and forks, for example, would be:
> Phil 0 picks up left fork (Fork 0)
> 
> Phil 1 picks up left fork (Fork 1) 
> 
> Phil 2 picks up left fork (Fork 2)
> 
> Phil 0 requests for right fork (Fork 1)
> 
> Phil 1 requests for right fork (Fork 2)
> 
> Phil 2 requests for right fork (Fork 0)
> 
> >Deadlock occurs.

My solution is such that the philosophers can only pick up forks in the order of the fork's index. Thus, Phil N-1 in N philosophers would choose to pick up their right fork before their left fork, as the right fork's index is 0, while the left fork's index is N-1. By ordering the acquiring of the locks of the forks, the above scenario of deadlock will never occur.

The above scenario would instead be:
> Phil 0 picks up left fork (Fork 0)
>
> Phil 1 picks up left fork (Fork 1)
>
> Phil 2 requests for right fork (Fork 0)
> 
> >as Phil 2 has to wait here for the Fork 0's lock, the philosophers holding said lock can complete their code and release the lock. 
> 
One possible safe pathway from here would be:
> Phil 1 picks up right fork (Fork 2)
>
> Phil 1 eats and puts down both forks (Forks 1 and 2)
> 
> Phil 0 picks up right fork (Fork 1)
> 
> Phil 0 eats and puts down both forks (Forks 0 and 1)
> 
> Phil 2 picks up right fork (Fork 0)
> 
> Phil 2 picks up left fork (Fork 2)
> 
> Phil 2 eats and puts down both forks (Forks 2 and 0)
> 
> > Deadlock avoided.