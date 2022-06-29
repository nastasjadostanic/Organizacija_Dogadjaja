import axios from 'axios';
import React, { Component } from 'react';

class ZahtevResursaComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           zahtevi: []

        }
       
        
    }
  vidiResurs(tipResursa, resursID){

        if(tipResursa=="Ljudski"){
            axios.get("http://localhost:8080/api/v1/ljudskiResursi/id/gost/" + resursID).then(response => {
                localStorage.setItem('activeResurs',JSON.stringify(response.data));
                });
                this.props.history.push(`/gostvidiljudski`);
        }
        else if (tipResursa=="Ostali"){
            axios.get("http://localhost:8080/api/v1/ostaliResursi/id/gost/" + resursID).then(response => {
                localStorage.setItem('activeResurs',JSON.stringify(response.data));
                });
                this.props.history.push(`/gostvidiostali`);
        }
        else{alert("Tip resursa neodgovarajuci")}

  }
  
logout() {
    localStorage.clear();
    this.props.history.push(`/login`);

}
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "gost" ){
        
           axios.get("http://localhost:8080/api/v1/zahteviresursa/gostId/gost/" + activeUser.id).then((res) => {
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