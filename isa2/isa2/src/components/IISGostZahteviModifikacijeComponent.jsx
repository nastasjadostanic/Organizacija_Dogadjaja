import axios from 'axios';
import React, { Component } from 'react';
//import ZahteviZaModifikacijuService from '../services/ZahteviZaModifikacijuService';

class GostZahteviModifikacijaComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           zahtevi: []

        }
       
    
    }
    logout() {
        localStorage.clear();
        this.props.history.push(`/login`);

    }
    vidiDogadjaj(dogadjajId){
        //uzeti dogadjaj po id i otvoriti novu stranicu prikaza dogadjaja
        axios.get("http://localhost:8080/api/v1/dogadjaji/" + dogadjajId).then(response => {
            localStorage.setItem('activeDogadjaj',JSON.stringify(response.data));
           });
        let dogadjaj = JSON.parse(localStorage.getItem('activeDogadjaj'));
           console.log(dogadjaj);

        //prikaz dogadjaja
        this.props.history.push(`/gostvididogadjaj`);
    }
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "gost" ){
        
           axios.get("http://localhost:8080/api/v1/zahteviModifikacije/gostId/gost/" + activeUser.id).then((res) => {
                this.setState({ zahtevi: res.data });
           });
        } 
        else{this.logout(); alert("Unauthorised access")} 
    }
    render() {
        return (
            <div>
                

                <h2 style={{position:'absolute',top:'100px',left:'35%'}} className="text-center">Zahtevi za modifikaciju sale </h2>

                <div className="row">
                    <table style={{position:'absolute', left:'0px',top:'200px'}} className="table table-striped table-borderd">
                        <thead>
                            <tr>
                                
                                
                                <th>Datum zahteva</th>
                                <th>Opis zahteva</th>
                                <th>Akcija</th>
                                
                              
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.zahtevi.map(
                                    zahtevi =>
                                        <tr key={zahtevi.id}>
                                            
                                            <td>{zahtevi.datumZahteva}</td>
                                            <td>{zahtevi.opisZahteva}</td>
                                            <td><button onClick={() => this.vidiDogadjaj(zahtevi.dogadjajID)} className="loginbtn">Vidi</button></td> 
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

export default GostZahteviModifikacijaComponent;