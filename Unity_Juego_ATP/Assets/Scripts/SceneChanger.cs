using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

///////////////////////////////////////////////////////////////////
//               JUEGO PARA EL APLICATIVO MÓVIL ATP              //
//  SCRIPT:      SceneChanger                                    //
//  DESCRIPCIÓN: Script que cambia las escenas                   //
//  AUTOR:       Lipa Ochoa, José                                //
//  FECHA:       07/07/2020                                      //
///////////////////////////////////////////////////////////////////

public class SceneChanger : MonoBehaviour
{
    public void ChangeSceneTo (string sceneName)
    {
        SceneManager.LoadScene(sceneName);                                         //Cambia a sceneName
    }
    public void NextScene()
    {
        SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex + 1);      //Build es el número
                                                                                   //La siguiente escena
    }
}
