import axios from 'axios';
import React, { Component } from 'react';
import LjudskiResursiService from '../services/LjudskiResursiService';

class GostLjudskiResursiComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           ljudskiresursi: []

        }
        
        this.zahtevZaKoriscenje = this.zahtevZaKoriscenje.bind(this);
    }
    zahtevZaKoriscenje(resursId){

        //ucitava activeResurs i otvara stranicu za kreiranje sa popunjenim poljima vezanim za resurs a dodaje polje za dogadjaj id 
        axios
        .get("http://localhost:8080/api/v1/ljudskiResursi/id/gost/" + resursId)
        .then(response => {
            localStorage.setItem('activeResurs',JSON.stringify(response.data));
            this.props.history.push(`/gostzahtevljudskiresurs`);
        });

        
    }
    
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
       
        if (activeUser.type == "gost" ){
        
           axios.get("http://localhost:8080/api/v1/ljudskiResursi").then((res) => {
                this.setState({ ljudskiresursi: res.data });
           });
        } 
        else{this.logout(); alert("Unauthorised access")} 
    }

    render() {
        return (
            <div>       
                <br />
                <h2 style={{position:'absolute',top:'100px',left:'45%'}} className="text-center">Ljudski resursi</h2>

                <div className="row">
                    <table style={{position:'absolute', left:'0px',top:'200px'}} className="table table-striped table-borderd">
                        <thead>
                            <tr>
                                <th>Naziv</th>
                                <th>Cena</th>
                                <th>Vrsta</th>
                                <th>Broj ljudi</th>
                                <th>Oblast delovanja</th>
                                <th>Broj telefona</th>

                                <th>Akcija</th>
                    
                            </tr>
                        </thead>
                        <tbody>
                            { this.state.ljudskiresursi.map(
                                    ljudskiresursi =>
                                        <tr key={ljudskiresursi.id}>
                                            <td>{ljudskiresursi.naziv} </td>
                                            <td>{ljudskiresursi.cena}</td>
                                            <td>{ljudskiresursi.vrsta}</td>
                                            <td>{ljudskiresursi.brojLjudi}</td>
                                            <td>{ljudskiresursi.oblastDelovanja}</td>
                                            <td>{ljudskiresursi.brojTelefona}</td>

                                                <td><button onClick={() => this.zahtevZaKoriscenje(ljudskiresursi.id)} className="loginbtn">Zahtevaj</button></td>
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

export default GostLjudskiResursiComponent;