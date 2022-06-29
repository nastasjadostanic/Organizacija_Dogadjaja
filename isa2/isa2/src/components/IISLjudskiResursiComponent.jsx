import axios from 'axios';
import React, { Component } from 'react';
import LjudskiResursiService from '../services/LjudskiResursiService';

class IISLjudskiResursiComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           ljudskiresursi: []

        }
        this.addLjudskiResurs = this.addLjudskiResurs.bind(this);
        this.delete = this.delete.bind(this);
    }
    
    
    addLjudskiResurs() {
        this.props.history.push("/dodajljudskiresurs");
    }
    
    delete(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));

        axios.delete("http://localhost:8080/api/v1/ljudskiResursi/"  + activeUser.type + "/" + id);
        window.location.reload();
    }
    update(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        axios
            .get("http://localhost:8080/api/v1/ljudskiResursi/id/organizator/"   + id)
            .then(response => {
                localStorage.setItem('activeLjudskiResurs', JSON.stringify(response.data));
                this.props.history.push(`/izmenaljudskihresursa`);
            });


    }
    
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "organizator"){
        
           axios.get("http://localhost:8080/api/v1/ljudskiResursi").then((res) => {
                this.setState({ ljudskiresursi: res.data });
           });
        } 
        else{this.logout(); alert("Unauthorised access")} 
    }

    changeSearchHandler = (event) => {
        this.setState({ search: event.target.value });
        

    }
    render() {
        return (
            <div>
                <button style={{position:'absolute', top:'150px', left:'1480px'}} onClick={() => this.addLjudskiResurs(this.props.match.params.id)} className="loginbtn">Add</button>
       
                

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
                            {
                                this.state.ljudskiresursi.map(
                                    ljudskiresursi =>
                                        <tr key={ljudskiresursi.id}>
                                            <td>{ljudskiresursi.naziv} </td>
                                            <td>{ljudskiresursi.cena}</td>
                                            <td>{ljudskiresursi.vrsta}</td>
                                            <td>{ljudskiresursi.brojLjudi}</td>
                                            <td>{ljudskiresursi.oblastDelovanja}</td>
                                            <td>{ljudskiresursi.brojTelefona}</td>

                                                <td>
                                                    <button onClick={() => this.update(ljudskiresursi.id)} className="loginbtn">Izmeni</button>
                                                    <button onClick={() => this.delete(ljudskiresursi.id)} className="loginbtn">Otkazi</button>
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

export default IISLjudskiResursiComponent;