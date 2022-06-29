import axios from 'axios';
import React, { Component } from 'react';
import LjudskiResursiService from '../services/LjudskiResursiService';

class LjudskiResursiComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           ljudskiresursi: []

        }
        
        this.obrisi = this.obrisi.bind(this);
    }
    obrisi(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        LjudskiResursiService.deleteLjudskiResurs(id,activeUser.type).then(res => {
            this.setState({ ljudskiresursi: this.state.ljudskiresursi.filter(ljudskiresurs => ljudskiresurs.id !== id) });
             
        });
        window.location.refresh();
    }
    
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        let activeDogadjaj =  JSON.parse(localStorage.getItem('activeDogadjaj'));
        if (activeUser.type == "organizator" ){
        
           axios.get("http://localhost:8080/api/v1/ljudskiResursi/dogadjaj/" + activeUser.type + "/" + activeDogadjaj.id ).then((res) => {
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

                                                <td><button onClick={() => this.obrisi(ljudskiresursi.id)} className="loginbtn">Obrisi</button></td>
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

export default LjudskiResursiComponent;