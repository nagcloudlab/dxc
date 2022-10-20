

const Rx=require('rxjs')


//----------------------------------------------------
// Trainer Module
//----------------------------------------------------

const stream=new Rx.BehaviorSubject("")

const trainer = {
    getSingleSubjectSync(){
        ///.. 10s
        return "sub-1"
    },
    getSingleSubjectAsync(){
        const promise = new Promise((resolve, reject) => {
            setTimeout(()=>{
                let sub="sub-1"
                resolve(sub) // push one data/err
            },10000)
        });
        return promise;
    },
    getFullstackSubjectsAsync(){
        let i=0;
        const interval=setInterval(()=>{
            i++;
            if(i==10){
            clearInterval(interval)
            stream.complete();

            }
            else{
            console.log("trainer propagating change / event / message into stream")
            stream.next(i)
            }
        },2000)
        return stream;
    }
}

//----------------------------------------------------
// Employee Module
//----------------------------------------------------

const vignesh={
    doLearnAndWork(){
        
        // let sub=trainer.getSingleSubjectSync() // pull / sync / blocking-call
        
        // const promise=trainer.getSingleSubjectAsync();
        
        // promise
        // .then(sub=>console.log("learning sub "+sub))
        // .catch(err=>{console.log(err);})
        // console.log("vignesh can cont doing something else")


        const stream=trainer.getFullstackSubjectsAsync();
        stream.subscribe({
            next: (sub)=>{
                console.log("employee reacting to change / event / message "+sub)
            },
            error: err=>{
                console.log(err)
            },
            complete:()=>{
                console.log("thanks trainer for all subjects")
            }
        });

    }
}

vignesh.doLearnAndWork()