import React, { Component } from 'react';
import axios from 'axios';

class IISAddDogadjajComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            ukupnaCena: '',
            datumNaplate: '',
            datumOdrzavanja: '',
            vremeOdrzavanja: '',
            trajanje: '',
            tip: '',
            salaID: ''
        }

        this.changeUkupnaCenaHandler = this.changeUkupnaCenaHandler.bind(this);
        this.changeDatumNaplateHandler = this.changeDatumNaplateHandler.bind(this);
        this.changeDatumOdrzavanjaHandler = this.changeDatumOdrzavanjaHandler.bind(this);
        this.changeVremeOdrzavanjaHandler = this.changeVremeOdrzavanjaHandler.bind(this);
        this.changeTrajanjeHandler = this.changeTrajanjeHandler.bind(this);
        this.changeTipHandler = this.changeTipHandler.bind(this);
        this.changeSalaIdHandler = this.changeSalaIdHandler.bind(this);
    }
    
    changeUkupnaCenaHandler = (event) => {
        this.setState({ ukupnaCena: event.target.value });
    }
    changeDatumNaplateHandler = (event) => {
        this.setState({ datumNaplate: event.target.value });
    }
    changeDatumOdrzavanjaHandler = (event) => {
        this.setState({ datumOdrzavanja: event.target.value });
    }
    changeVremeOdrzavanjaHandler = (event) => {
        this.setState({ vremeOdrzavanja: event.target.value });
    }
    changeTrajanjeHandler = (event) => {
        this.setState({ trajanje: event.target.value });
    }
    changeTipHandler = (event) => {
        this.setState({ tip: event.target.value });
    }
    changeSalaIdHandler = (event) => {
        this.setState({ salaID: event.target.value });
    }

    logout() {
        localStorage.clear();
        this.props.history.push(`/login`);

    }

    Add() {
        //let activeCottage =  JSON.parse(localStorage.getItem('activeCottage'));

        let dogadjaj = {           
            id:this.state.id,
            ukupnaCena:this.state.ukupnaCena,
            datumNaplate:this.state.datumNaplate,
            datumOdrzavanja:this.state.datumOdrzavanja,
            vremeOdrzavanja:this.state.vremeOdrzavanja,
            trajanje:this.state.trajanje,
            tip :this.state.tip,
            salaID:this.state.salaID
        }
        
        console.log('dogadjaj => ' + JSON.stringify(dogadjaj));
        axios.post("http://localhost:8080/api/v1/dogadjaji",dogadjaj);
        this.props.history.push(`/dogadjaji`);
        window.location.reload();
    }

    componentDidMount() {
        let activeUser = JSON.parse(localStorage.getItem('activeUser'))

        if (activeUser.type != "organizator") { this.logout(); alert("Unauthorised access") }
    }
    render() {
        return (
            <div>
                

                <div className="registrationdiv">
                    <br /><br />
                    <label> Ukupna cena: </label>
                    <input  name="ukupnaCena" className="form-control" value={this.state.ukupnaCena} onChange={this.changeUkupnaCenaHandler} />
                    <label> Datum naplate: </label>
                    <input type="date" name="datumNaplate" className="form-control" value={this.state.datumNaplate} onChange={this.changeDatumNaplateHandler} />
                    <label> Datum odrzavanja: </label>
                    <input type="date" name="datumOdrzavanja" className="form-control" value={this.state.datumOdrzavanja} onChange={this.changeDatumOdrzavanjaHandler} />
                    <label> Vreme odrzavanja: </label>
                    <input name="vremeOdrzavanja" className="form-control" value={this.state.vremeOdrzavanja} onChange={this.changeVremeOdrzavanjaHandler} />
                    <label> Trajanje: </label>
                    <input name="trajanje" className="form-control" value={this.state.trajanje} onChange={this.changeTrajanjeHandler} />
                    <label> Tip: </label>
                    <input name="tip" className="form-control" value={this.state.tip} onChange={this.changeTipHandler} />
                    <label> Sala id: </label>
                    <input name="salaId" className="form-control" value={this.state.salaID} onChange={this.changeSalaIdHandler} />

                    <br />
                    <div className="center"><button className="loginbtn" onClick={()=>this.Add()}>Add</button></div>



                </div>
            </div>

        );
    }
}

export default IISAddDogadjajComponent;