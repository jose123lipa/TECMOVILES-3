using System.Collections;
using System.Collections.Generic;
using UnityEngine;

///////////////////////////////////////////////////////////////////
//               JUEGO PARA EL APLICATIVO MÓVIL ATP              //
//  SCRIPT:      WinCondition                                    //
//  DESCRIPCIÓN: Script que controla condición de ganar          //
//  AUTOR:       Chura Chambi, Pabel - Ccuno Carlos, Paul        //
//  FECHA:       08/07/2020                                      //
///////////////////////////////////////////////////////////////////

public class WinCondition : MonoBehaviour
{
    public SceneChanger changeScene;
    void OnTriggerEnter2D (Collider2D collider)
    {
        if (collider.tag == "Player")                //Si es el player
        {   
            changeScene.ChangeSceneTo("WinScene");   //Cambia a sceneName
        }
    }
}
