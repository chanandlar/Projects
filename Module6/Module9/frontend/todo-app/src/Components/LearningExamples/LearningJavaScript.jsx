const person={
    name:'Sherlock Holmes',
    address:{
        line1:'Baker Street',
        city:'London',
        country:'UK',
    },
    profiles:['twitter','Linkedin','Instagram'],
    // printProfile:() =>{
    //     person.profiles.map(
    //         (profile) => {
    //             console.log(profile)
    //         }
    //     )
    //     console.log(person.profiles[0]);
    // }
    printProfile:()=>{
        console.log(person.profiles[0]);
    }
}



export default function LearningJavaScript(){
    return (
        <>
        <div>{person.name}</div> 
        <div>{person.address.city}</div>
        <div>{person.profiles[1]}</div>
        <div>{person.printProfile()}</div>
        </>
    )
}