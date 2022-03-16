//
//  MainViewController.swift
//  iosApp
//
//  Created by Kevin Damore on 2/2/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import UIKit
import SnapKit
import iOSX_shared

class JokeViewController: UIViewController {
    
    private let jokeButton: UIButton = UIButton(frame: .zero)
    private let resultLabel: UILabel = UILabel(frame: .zero)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        jokeButton.backgroundColor = .blue
        jokeButton.setTitle("Get Joke", for: [])
        jokeButton.addTarget(self, action: #selector(onClick), for: .touchUpInside)
        
        resultLabel.textAlignment = .center
        resultLabel.textColor = .white
        resultLabel.numberOfLines = 0
        
        view.addSubview(jokeButton)
        view.addSubview(resultLabel)
        
        jokeButton.snp.makeConstraints { make in
            make.width.equalTo(200.0)
            make.height.equalTo(80.0)
            make.top.equalToSuperview().offset(50.0)
            make.centerX.equalToSuperview()
        }
        
        resultLabel.snp.makeConstraints { make in
            make.left.right.equalToSuperview().inset(20.0)
            make.top.equalTo(jokeButton.snp.bottom).offset(50.0)
        }
    }
    
    private func getJoke() {
        resultLabel.text = "Getting joke.."
        JokeAPI().getJoke { joke, error in
            self.resultLabel.text = joke?.debugDescription
        }
    }
    
    @objc func onClick(_ sender: UIButton) {
        switch sender {
        case jokeButton:
            getJoke()
        default:
            break
        }
    }
}

extension String {

    func localized() -> String {
        return NSLocalizedString(self, comment: "")
    }
}
