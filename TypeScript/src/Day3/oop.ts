abstract class Devloper{
    #name: string
    #skills: string[] 

    setSkill(skill:string){
        this.#skills.push(skill)
    }
    
    constructor(name:string){
        this.#name = name
        this.#skills = []
    }

  

    abstract work():void;

    getPostionInCompany(){
       return " i am software enginner"
    }
}

class frontendDevloper extends Devloper{
  

    constructor(name:string){
        super(name)
    }

    work(){
        console.log("i make fronter of website");
    }


    getPostionInCompany(){
        return " i am frontend enginner"
     }


    
}
class BackendDevloper extends Devloper{
  

    constructor(name:string){
        super(name)
    }

    work(){
        console.log("i write apis ");
    }


    getPostionInCompany(){
        return " i am backend enginner"
     }



    
}


