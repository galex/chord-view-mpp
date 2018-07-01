//
// Created by Alexandre Gherschon on 26/06/2018.
// Copyright (c) 2018 galex.co.il. All rights reserved.
//

import Foundation
import UIKit
import KotlinNativeFramework

class ChordView: UIView {

    @IBOutlet var view: UIView!
    
    var ukuleleChord: KNFUkuleleChord?
    private var linesLayer: CAShapeLayer?
    private var dotsLayer: CAShapeLayer?
    
    convenience init(frame: CGRect, chord: KNFUkuleleChord) {
        self.init(frame: frame)
        
        ukuleleChord = chord
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        commonInit()
        
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        
        commonInit()
    }
    
    func commonInit() {
        Bundle.main.loadNibNamed("ChordView", owner: self, options: nil)
        addSubview(view)
        view.frame = self.bounds
        view.autoresizingMask = [.flexibleHeight, .flexibleWidth]
    }
    
    override func draw(_ rect: CGRect) {
        super.draw(rect)
        NSLog("draw. frame is \(frame)")

        
        if linesLayer == nil {
            linesLayer = CAShapeLayer()
            view.layer.addSublayer(linesLayer!)
        }
        if dotsLayer == nil {
            dotsLayer = CAShapeLayer()
            view.layer.addSublayer(dotsLayer!)
        }
        
        var linesCount = 0
        var circlesCount = 0
        let aPath = UIBezierPath()
        
        let helper = KNFChordViewHelper()
        helper.drawGrid(viewWidth: Float(frame.width), currentHeight: Float(frame.height), renderLine: { (x, y, endX, endY) in
            NSLog("drawing line from \(x),\(y) to \(endX),\(endY)")
            
            aPath.move(to: CGPoint(x: CGFloat(truncating: x), y: CGFloat(truncating: y)))
            aPath.addLine(to: CGPoint(x: CGFloat(truncating: endX), y: CGFloat(truncating: endY)))
            
            linesCount += 1
            
            if linesCount == 10 {
                NSLog("drawing liones")
                self.linesLayer?.path = aPath.cgPath
                self.linesLayer?.strokeColor = UIColor.black.cgColor
                self.linesLayer?.lineWidth = 5
            }
            
            return KNFStdlibUnit()
        })
        
        helper.drawPositions(viewWidth: Float(frame.width), currentHeight: Float(frame.height), ukuleleChord: ukuleleChord!, renderCircle: { (x, y) in
            NSLog("drawing dot at \(x),\(y)")
            
            let circlePath = UIBezierPath(arcCenter: CGPoint(x: CGFloat(truncating: x), y: CGFloat(truncating: y)), radius: 10, startAngle: CGFloat(0), endAngle:CGFloat(Double.pi * 2), clockwise: true)
            
            circlesCount += 1
            
            if circlesCount == 2 {
                self.dotsLayer?.path = circlePath.cgPath
                self.dotsLayer?.fillColor = UIColor.black.cgColor
            }
            
            return KNFStdlibUnit()
        })
        
    }
}
