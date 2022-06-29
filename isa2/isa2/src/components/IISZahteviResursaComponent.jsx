import axios from 'axios';
import React, { Component } from 'react';

class ZahtevResursaComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           zahtevi: []

        }
       
        this.delete = this.delete.bind(this);
        this.prihvati = this.prihvati.bind(this);
    }
    
    
    delete(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        axios.delete("http://localhost:8080/api/v1/zahteviResursa/" +activeUser.type + "/" + id);
        window.location.reload();
    }

    prihvati(dogadjajID, tipResursa, resursID, zahtevId){
    //treba izmeniti dogadjaj ljudskiResursId ili ostaliResursId spram tipResursa iz zahteva

    //uzizmanje dogadjaja koji zelimo da updatujemo 
    axios.get("http://localhost:8080/api/v1/dogadjaji/" + dogadjajID).then(response => {
        localStorage.setItem('activeDogadjaj',JSON.stringify(response.data));
        });
        
    let activeDogadjaj = JSON.parse(localStorage.getItem('activeDogadjaj'));
    
    // u trenutni treba staviti izmenu resursa ali spram toga kog je tipa

    if(tipResursa=="Ljudski"){

        let activeDogadjaj2 = { 
            id: activeDogadjaj.id,
            ukupnaCena: activeDogadjaj.ukupnaCena,
            datumNaplate: activeDogadjaj.datumNaplate,
            datumOdrzavanja: activeDogadjaj.datumOdrzavanja,
            vremeOdrzavanja:activeDogadjaj.vremeOdrzavanja,
            trajanje: activeDogadjaj.trajanje,
            tip: activeDogadjaj.tip,
            salaID: activeDogadjaj.salaID,
            modifikacijaSale:activeDogadjaj.modifikacijaSale,
    
    
            ljudskiResursId:resursID,
            ostaliResursId: activeDogadjaj.ostaliResursId
         
        }
        console.log(activeDogadjaj2);
        //update dogadjaja tako da koristi koji smo resurs prihvatili iz zahteva
        axios.put("http://localhost:8080/api/v1/dogadjaji/organizator/" + dogadjajID, activeDogadjaj2);
    }
    else if (tipResursa=="Ostali"){
        let activeDogadjaj2 = { 
            id:activeDogadjaj.id,
            ukupnaCena: activeDogadjaj.ukupnaCena,
            datumNaplate: activeDogadjaj.datumNaplate,
            datumOdrzavanja: activeDogadjaj.datumOdrzavanja,
            vremeOdrzavanja:activeDogadjaj.vremeOdrzavanja,
            trajanje: activeDogadjaj.trajanje,
            tip: activeDogadjaj.tip,
            salaID: activeDogadjaj.salaID,
            modifikacijaSale:activeDogadjaj.modifikacijaSale,


            ljudskiResursId:activeDogadjaj.ljudskiResursId,
            ostaliResursId: resursID
     
        }
        console.log(activeDogadjaj2);
        //update dogadjaja tako da koristi koji smo resurs prihvatili iz zahteva
        axios.put("http://localhost:8080/api/v1/dogadjaji/organizator/" + dogadjajID, activeDogadjaj2);
    }
    else{alert("Tip resursa neodgovarajuci")}

    //brisanje iz zahteva

    let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        axios.delete("http://localhost:8080/api/v1/zahteviresursa/" +activeUser.type + "/" + zahtevId);
        window.location.reload();

    
    
  }
  vidiResurs(tipResursa, resursID){

        if(tipResursa=="Ljudski"){
            axios.get("http://localhost:8080/api/v1/ljudskiResursi/id/organizator/" + resursID).then(response => {
                localStorage.setItem('activeResurs',JSON.stringify(response.data));
                });
                this.props.history.push(`/vidiljudski`);
        }
        else if (tipResursa=="Ostali"){
            axios.get("http://localhost:8080/api/v1/ostaliResursi/id/organizator/" + resursID).then(response => {
                localStorage.setItem('activeResurs',JSON.stringify(response.data));
                });
                this.props.history.push(`/vidiostali`);
        }
        else{alert("Tip resursa neodgovarajuci")}

  }
  vidiDogadjaj(dogadjajID){

   
        axios.get("http://localhost:8080/api/v1/dogadjaji/" + dogadjajID).then(response => {
            localStorage.setItem('activeDogadjaj',JSON.stringify(response.data));
            });
            this.props.history.push(`/vididogadjaj`);
    
    

}
    
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "organizator" ){
        
           axios.get("http://localhost:8080/api/v1/zahteviresursa").then((res) => {
                this.setState({ zahtevi: res.data });
           });
        } 
        else{this.logout(); alert("Unauthorised access")} 
    }
    render() {
        return (
            <div>
                

                <h2 style={{position:'absolute',top:'100px',left:'35%'}} className="text-center">Zahtevi za koriscenje resursa </h2>

                <div className="row">
                    <table style={{position:'absolute', left:'0px',top:'200px'}} className="table table-striped table-borderd">
                        <thead>
                            <tr>
                                
                                
                                <th>Datum zahteva</th>
                                <th>Tip resursa</th>
                                <th>Resurs</th>
                                <th>Dogadjaj</th>
                                <th>Akcija</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.zahtevi.map(
                                    zahtevi =>
                                        <tr key={zahtevi.id}>
                                            
                                            <td>{zahtevi.datumZahteva}</td>
                                            <td>{zahtevi.tipResursa}</td>
                                            <td><button onClick={() => this.vidiResurs(zahtevi.tipResursa,zahtevi.resursID)} className="loginbtn">Vidi</button></td>
                                            <td><button onClick={() => this.vidiDogadjaj(zahtevi.dogadjajID)} className="loginbtn">Vidi</button></td>
                                                    
                                                <td>
                                                    <button onClick={() => this.prihvati(zahtevi.dogadjajID, zahtevi.tipResursa,zahtevi.resursID, zahtevi.id)} className="loginbtn">Prihvati</button>
                                                    <button onClick={() => this.delete(zahtevi.id)} className="loginbtn">Odbij</button>
                                                </td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ZahtevResursaComponent;