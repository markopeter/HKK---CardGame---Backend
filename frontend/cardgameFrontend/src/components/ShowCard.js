import React, {useEffect, useState} from 'react';
import axios from "axios";
import ShowCardResult from "./ShowCardResult";

const ShowCard = () => {
    const [card, setCard] = useState([])
    const url = "https://hkk-petproject.herokuapp.com/creatures";
    const fetchCards = async () => {
        await axios.get(url).then((response) => {
            console.log(response);
            const data = response.data;
            setCard(data);
        });
    }

    return (
        <div>
            <button onClick={fetchCards}>Show cards ! </button>
            <ShowCardResult data={card}/>
        </div>
    );
};

export default ShowCard;
