import React, { Component } from 'react';
import axios from 'axios';

class IISAddOstaliResursComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            naziv: '',
            cena: '',
            tip: '',
            boja: '',
            stil: '',
            kolicina: ''
        }

        this.changeNazivHandler = this.changeNazivHandler.bind(this);
        this.changeCenaHandler = this.changeCenaHandler.bind(this);
        this.changeTipHandler = this.changeTipHandler.bind(this);
        this.changeBojaHandler = this.changeBojaHandler.bind(this);
        this.changeStilHandler = this.changeStilHandler.bind(this);
        this.changeKolicinaHandler = this.changeKolicinaHandler.bind(this);

    }
    
    changeNazivHandler = (event) => {
        this.setState({ naziv: event.target.value });
    }
    changeCenaHandler = (event) => {
        this.setState({ cena: event.target.value });
    }
    changeTipHandler = (event) => {
        this.setState({ tip: event.target.value });
    }
    changeBojaHandler = (event) => {
        this.setState({ boja: event.target.value });
    }
    changeStilHandler = (event) => {
        this.setState({ stil: event.target.value });
    }
    changeKolicinaHandler = (event) => {
        this.setState({ kolicina: event.target.value });
    }

    logout() {
        localStorage.clear();
        this.props.history.push(`/login`);

    }

    Add() {
        
        let ostaliresurs = {           
            id:this.state.id,
            naziv:this.state.naziv,
            cena:this.state.cena,
            tip:this.state.tip,
            boja:this.state.boja,
            stil:this.state.stil,
            kolicina :this.kolicina
            
        }
        let activeUser = JSON.parse(localStorage.getItem('activeUser'))
        console.log('ostaliresurs => ' + JSON.stringify(ostaliresurs));
        axios.post("http://localhost:8080/api/v1/ostaliResursi/" +activeUser.type ,ostaliresurs);
        this.props.history.push(`/ostaliresursi`);
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
                    <label> Naziv: </label>
                    <input  name="naziv" className="form-control" value={this.state.naziv} onChange={this.changeNazivHandler} />
                    <label> Cena: </label>
                    <input name="cena" className="form-control" value={this.state.cena} onChange={this.changeCenaHandler} />
                    <label> Tip: </label>
                    <input name="tip" className="form-control" value={this.state.tip} onChange={this.changeTipHandler} />
                    <label> Boja: </label>
                    <input name="boja" className="form-control" value={this.state.boja} onChange={this.changeBojaHandler} />
                    <label> Stil: </label>
                    <input name="stil" className="form-control" value={this.state.stil} onChange={this.changeStilHandler} />
                    <label> Kolicina: </label>
                    <input name="kolicina" className="form-control" value={this.state.kolicina} onChange={this.changeKolicinaHandler} />
                
                    <br />
                    <div className="center"><button className="loginbtn" onClick={()=>this.Add()}>Add</button></div>



                </div>
            </div>

        );
    }
}

export default IISAddOstaliResursComponent;